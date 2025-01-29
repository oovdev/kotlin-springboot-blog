package com.oovdev.domain.comment

import com.oovdev.domain.AuditingEntity
import com.oovdev.domain.post.Post
import javax.persistence.*

@Table(name = "Comment")
@Entity
class Comment(
    content: String,
    post: Post,
): AuditingEntity() {

    @Column(name = "content", nullable =  false)
    var content: String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post::class)
    var post: Post = post
        protected set
}
