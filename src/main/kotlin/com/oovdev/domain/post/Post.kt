package com.oovdev.domain.post

import com.oovdev.domain.AuditingEntity
import javax.persistence.*

@Table(name = "Post")
@Entity
class Post(
    title: String,
    content: String,
) : AuditingEntity() {

    @Column(name = "title", nullable = false)
    var title: String = title
        protected set

    @Column(name = "content", nullable = true)
    var content: String = content
        protected set
}