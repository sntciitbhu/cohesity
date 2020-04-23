from django.db import models
from django.conf import settings
from django.contrib.auth.models import User


class Diabetes(models.Model):
    person = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    dia_data = models.IntegerField()

    def __str__(self):
        return "%s" % self.dia_data


class BP(models.Model):
    patient = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    high = models.IntegerField()
    low = models.IntegerField()
