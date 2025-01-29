package com.oovdev.domain.post

import com.oovdev.domain.AuditingEntity
import com.oovdev.domain.member.Member
import javax.persistence.*

@Table(name = "Post")
@Entity
class Post(
    title: String,
    content: String,
    member: Member,
) : AuditingEntity() {

    @Column(name = "title", nullable = false)
    var title: String = title
        protected set

    @Column(name = "content", nullable = true)
    var content: String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member::class)
    var member: Member = member
        protected set
}
