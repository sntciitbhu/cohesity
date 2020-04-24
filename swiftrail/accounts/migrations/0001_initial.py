# Generated by Django 2.2.7 on 2019-11-29 02:28

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('auth', '0011_update_proxy_permissions'),
    ]

    operations = [
        migrations.CreateModel(
            name='Profile',
            fields=[
                ('user', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, primary_key=True, serialize=False, to=settings.AUTH_USER_MODEL)),
                ('gender', models.CharField(choices=[('M', 'Male'), ('F', 'Female'), ('O', 'Others/Not Specified')], max_length=1)),
                ('phone_number', models.CharField(max_length=10)),
                ('date_of_birth', models.DateField()),
                ('address', models.TextField()),
            ],
        ),
    ]