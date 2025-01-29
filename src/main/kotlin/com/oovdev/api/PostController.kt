package com.oovdev.api

import com.oovdev.service.PostService
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
    private val postService: PostService,
) {
}