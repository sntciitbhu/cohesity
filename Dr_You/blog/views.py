from django.utils import timezone
from .models import Post,Post1
from .forms import PostForm,PostForm1
from django.shortcuts import render, get_object_or_404 , redirect
from django.contrib.auth.decorators import login_required




def post_detail(request, pk):
    post = get_object_or_404(Post, pk=pk)
    return render(request, 'post_detail.html', {'post': post})


def post_edit(request, pk):
    post = get_object_or_404(Post, pk=pk)
    if request.method == "POST":
        form = PostForm(request.POST, instance=post)
        if form.is_valid():
            post = form.save(commit=False)
            post.author = request.user

            post.save()
            return redirect('post_detail', pk=post.pk)
    else:
        form = PostForm(instance=post)
    return render(request, 'post_edit.html', {'form': form})

@login_required
def post_new(request):
    #if not request.user.is_autenticated:
    #    return render(request, 'please_login.html')
    if request.method == "POST":
        form = PostForm(request.POST)
        print(form.errors)
        if form.is_valid():
            data = form.cleaned_data['text']
            lulls = form.cleaned_data['tag']
            post = form.save(commit=False)
            #data = post.cleaned_data['text']
            if len(data) < 150:
                x = data + '...'
            else:
                x = data[:140] + '.....'
            post.tag = lulls
            post.snippet = x

            post.author = request.user
            post.save()
            return redirect('post_detail', pk=post.pk)
    else:
        form = PostForm()
    return render(request, 'post_edit.html', {'form': form})


def post_all(request):
    if request.method == "POST" :
        form = PostForm1(request.POST)
        if form.is_valid():
            lulls = form.cleaned_data['tag']
            print(lulls)
            posts = Post.objects.filter(tag=lulls)
            return render(request, 'post_all.html' , {'posts' : posts})
    print("Invalid")
    posts = Post.objects.all()
    return render(request, 'post_all.html', {'posts': posts})


def testview(request):
    return render(request, 'blog-home.html', {'posts': Post.objects.all()})
