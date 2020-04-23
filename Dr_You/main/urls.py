from django.urls import path, include
from . import views
urlpatterns = [
    path('', views.HomePageView, name='home'),
    path('sugar_level/', views.DisplayViewSugar, name='sugar'),
    path('blood_pressure', views.DisplayViewBP, name='bp'),
    path('base/', views.BaseView, name='base'),
]
