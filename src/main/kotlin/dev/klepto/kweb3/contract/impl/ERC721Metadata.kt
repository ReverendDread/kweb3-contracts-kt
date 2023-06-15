package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.abi.type.Uint
import dev.klepto.kweb3.contract.Contract
import dev.klepto.kweb3.contract.View

/**
 * ERC-721 Non-Fungible Token Standard, optional metadata extension
 * @see <a href="https://eips.ethereum.org/EIPS/eip-721">ERC-721 Non-Fungible Token Standard</a>
 *
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 2:59 PM
 */
interface ERC721Metadata : Contract {

    /**
     * @return A descriptive name for a collection of NFTs in this contract
     */
    @View
    fun name(): String

    /**
     * @return An abbreviated name for NFTs in this contract
     */
    @View
    fun symbol(): String

    /**
     * @param tokenId The identifier for an NFT
     * @return A distinct Uniform Resource Identifier (URI) for a given asset
     */
    @View
    fun tokenURI(tokenId: String): String

    companion object {
        const val INTERFACE_ID = "0x5b5e139f"
    }

}