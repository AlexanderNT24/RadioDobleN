from django.contrib import admin
from filter_app.models import Post

@admin.register(Post)
class PostAdmin(admin.ModelAdmin):
    list_display=['title','content']    