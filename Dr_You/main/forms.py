from django import forms
from .models import Diabetes, BP


class DiabetesForm(forms.ModelForm):

    class Meta:
        model = Diabetes
        fields = ('dia_data',)

class BPForm(forms.ModelForm):

    class Meta:
        model = BP
        fields = ('high', 'low')
