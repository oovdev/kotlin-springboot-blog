package com.oovdev.api

import com.oovdev.domain.member.Member
import com.oovdev.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService,
) {

    @GetMapping("/members")
    fun findAll(): MutableList<Member> = memberService.findAll()
}
