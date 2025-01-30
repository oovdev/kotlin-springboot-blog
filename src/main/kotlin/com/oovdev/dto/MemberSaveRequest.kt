package com.oovdev.dto

import com.oovdev.domain.member.Member
import com.oovdev.domain.member.Role

data class MemberSaveRequest(
    val email: String,
    val password: String,
    val role: Role,
)

fun MemberSaveRequest.toEntity(): Member {
    return Member(
        email = this.email,
        password = this.password,
        role = this.role,
    )
}
