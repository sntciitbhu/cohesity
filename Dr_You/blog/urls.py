from django.urls import path
from . import views

urlpatterns = [
    path('', views.post_detail, name='post_list'),
    path('post/<int:pk>/', views.post_detail, name='post_detail'),
    path('post/all', views.post_all, name='post_all'),
    path('post/new/', views.post_new, name='post_new'),
]
