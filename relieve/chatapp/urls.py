from django.conf.urls import url
from . import views

urlpatterns =[
    
    url(r'^(?P<doc_user>[0-9A-Za-z]+)/$', views.index, name='index'),
    
    ]