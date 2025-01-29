package com.oovdev.service

import com.oovdev.domain.member.Member
import com.oovdev.domain.member.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {

    @Transactional(readOnly = true)
    fun findAll(): MutableList<Member> = memberRepository.findAll()
}