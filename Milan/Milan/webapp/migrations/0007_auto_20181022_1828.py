# Generated by Django 2.0 on 2018-10-22 18:28

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('webapp', '0006_auto_20181022_1807'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='found',
            name='status',
        ),
        migrations.RemoveField(
            model_name='lost',
            name='status',
        ),
    ]
