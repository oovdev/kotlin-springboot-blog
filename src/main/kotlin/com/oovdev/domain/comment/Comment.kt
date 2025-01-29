package com.oovdev.domain.comment

import com.oovdev.domain.AuditingEntity
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "Comment")
@Entity
class Comment(

): AuditingEntity() {


}