from django.contrib import admin
from django.urls import path,include

from filter_app.api.router import router_posts

urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/', include(router_posts.urls)),
]
