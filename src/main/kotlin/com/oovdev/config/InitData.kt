package com.oovdev.config

import com.oovdev.domain.member.Member
import com.oovdev.domain.member.MemberRepository
import com.oovdev.domain.member.Role
import com.oovdev.dto.MemberSaveRequest
import com.oovdev.dto.toEntity
import io.github.serpro69.kfaker.faker
import mu.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class InitData(
    private val memberRepository: MemberRepository,
) {

    val faker = faker {}
    private val log = KotlinLogging.logger {}

    @EventListener(ApplicationReadyEvent::class)
    fun onApplicationReady() {

        val members = generateMembers()

        log.info { "Initializing ${members.size} members" }
        log.info { "Inserted last member: ${members[members.size - 1].toString()}" }

        memberRepository.saveAll(members)
    }

    private fun generateMembers(): List<Member> = List(100) {
            MemberSaveRequest(
                email = faker.internet.safeEmail(),
                password = "qwer#1234@",
                role = Role.USER
            ).toEntity()
        }
}