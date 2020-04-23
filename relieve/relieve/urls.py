

from django.contrib import admin
from django.urls import path, include
from django.conf.urls import url
from django.conf import settings
from django.conf.urls.static import static
from myapp.views import index
urlpatterns = [

    path('admin/', admin.site.urls),
    url(r'^auth/', include('social_django.urls', namespace='social')),
    url(r'^chat/',include('chatapp.urls')),
    path('paytm/', include('paytm.urls')),
    path('cart', include('cart.urls')),
    path('orders/', include('orders.urls')),
    path('shop/', include('shop.urls')),
    url(r'^$', index, name='index'),
    url(r'^myapp/', include('myapp.urls', namespace='myapp')),# same as app_name in urls.py of music
]

if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)
    urlpatterns += static(settings.STATIC_URL, document_root = settings.STATIC_ROOT)
