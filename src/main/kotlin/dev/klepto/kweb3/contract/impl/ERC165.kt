package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.contract.View

/**
 * Standard Interface Detection
 * @see <a href="https://eips.ethereum.org/EIPS/eip-165">EIP-165</a>
 *
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 2:59 PM
 */
interface ERC165 {

    /**
     * @return true if the contract implements the interface defined by [interfaceId]
     * @param interfaceId The interface identifier, as specified in ERC-165
     * @return true if the contract implements the interface defined by [interfaceId]
     */
    @View
    fun supportsInterface(interfaceId: String): Boolean

    companion object {
        const val INTERFACE_ID_ERC165 = "0x01ffc9a7"
    }

}