# Generated by Django 2.0.1 on 2019-03-06 10:09

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('chatapp', '0002_chatsave_user_type'),
    ]

    operations = [
        migrations.RenameField(
            model_name='chatsave',
            old_name='user_type',
            new_name='is_doctor',
        ),
    ]