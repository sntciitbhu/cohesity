from django.contrib import admin
from .models import Doctor,UserSave
from social_django.models import *
# Register your models here.
admin.site.register(Doctor)
admin.site.register(UserSave)
#admin.site.register(USER_MODEL)