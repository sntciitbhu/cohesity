from django.shortcuts import render
from django.http import HttpResponse
from django.utils.translation import get_language
from django.views.decorators.csrf import csrf_exempt
from django.contrib.auth.decorators import login_required
from django.conf import settings

from . import Checksum


from paytm.models import PaytmHistory
from orders.models import Order

from django.core.mail import send_mail


@csrf_exempt
def response(request):
    if request.method == "POST":
        MERCHANT_KEY = settings.PAYTM_MERCHANT_KEY
        data_dict = {}
        user=request.POST['ORDERID']
        RES = int(request.POST['RESPCODE'])
        for key in request.POST:
            data_dict[key] = request.POST[key]

        verify = Checksum.verify_checksum(data_dict, MERCHANT_KEY, data_dict['CHECKSUMHASH'])
        if verify:
            PaytmHistory.objects.create(user=user, **data_dict)
            if RES == 1:
                curr_user = Order.objects.filter(order_id=user)[0]
                curr_user.paid=True
                username = curr_user.username
                mail_body = 'payment confirm with order id %s and tranction id %s of %s INR'%(user,data_dict['TXNID'],data_dict['TXNAMOUNT'])
                send_mail(
                    'Payment Confirmation from Campussquare',
                    mail_body,
                    'albertgovind17@gmail.com',
                    [curr_user.email],
                    fail_silently=False,
                )
                curr_user.save()
            return render(request,"paytm/response.html",{"paytm":data_dict})
        else:
            return HttpResponse("checksum verify failed")
    return HttpResponse(status=200)