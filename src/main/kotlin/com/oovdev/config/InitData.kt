package com.oovdev.config

import com.oovdev.domain.member.Member
import com.oovdev.domain.member.MemberRepository
import com.oovdev.domain.member.Role
import io.github.serpro69.kfaker.faker
import mu.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import kotlin.random.Random

@Configuration
class InitData(
    private val memberRepository: MemberRepository,
) {

    val faker = faker {}
    private val log = KotlinLogging.logger {}

    @EventListener(ApplicationReadyEvent::class)
    fun onApplicationReady() {

        val random = Random(System.currentTimeMillis())

        val members = List(10) {
            Member(
                email = faker.internet.safeEmail(),
                password = random.nextInt(10001, 99999999).toString(),
                role = Role.USER
            )
        }

        log.info { "Initializing ${members.size} members" }
        log.info { "Inserted last member: ${members[members.size - 1].toString()}" }

        memberRepository.saveAll(members)
    }
}