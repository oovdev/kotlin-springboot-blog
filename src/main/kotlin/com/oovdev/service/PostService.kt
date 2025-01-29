package com.oovdev.service

import com.oovdev.domain.member.MemberRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val memberRepository: MemberRepository,
) {


}