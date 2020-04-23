from django.db import models
from django.utils import timezone
from django.conf import settings


class Post(models.Model):
    author = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    title = models.CharField(max_length=200)
    text = models.TextField()
    snippet = models.TextField(default='These were generated earlier.')
    tag = models.CharField(max_length=20, default='Misc')
    created_date = models.DateTimeField(default=timezone.now)

    def __str__(self):
        return self.title

class Post1(models.Model):
    tag = models.CharField(max_length=200)

    def __str__(self):
        return self.tag
