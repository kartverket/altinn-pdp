package no.kartverket.altinnpdp.client.support

import no.kartverket.altinnpdp.client.auth.AltinnToken
import no.kartverket.altinnpdp.client.auth.AltinnTokenProvider
import java.time.Instant

internal class FakeTokenProvider(
    private val token: String = "altinn-token",
) : AltinnTokenProvider {

    var calls = 0
        private set

    override suspend fun getAltinnToken(): AltinnToken {
        calls++
        return AltinnToken(token, Instant.MAX)
    }
}
