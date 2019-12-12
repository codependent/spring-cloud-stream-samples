package kafka.e2e.customer.producer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import reactor.core.publisher.Mono
import reactor.core.publisher.MonoProcessor
import java.util.function.Supplier

/**
 * @author José A. Íñigo
 */
@Configuration
class ProducerConfiguration {

    @Bean
    fun customerEmitter(): MonoProcessor<Message<*>> {
        return MonoProcessor.create<Message<*>>()
    }

    @Bean
    fun customer(): Supplier<Mono<Message<*>>> {
        return Supplier { customerEmitter() }
    }

}
