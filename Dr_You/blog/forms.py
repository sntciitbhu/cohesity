from django import forms

from .models import Post,Post1

class PostForm(forms.ModelForm):

    class Meta:
        model = Post
        fields = ('title', 'text', 'tag',)

class PostForm1(forms.ModelForm):

    class Meta:
        model = Post1
        fields = ('tag',)
