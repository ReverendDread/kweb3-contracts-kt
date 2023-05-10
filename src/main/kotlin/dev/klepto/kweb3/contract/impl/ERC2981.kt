package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.abi.type.Tuple
import dev.klepto.kweb3.abi.type.Uint
import dev.klepto.kweb3.contract.Contract
import dev.klepto.kweb3.contract.Type
import dev.klepto.kweb3.contract.View

/**
 * NFT Royalty Standard
 * @see <a href="https://eips.ethereum.org/EIPS/eip-2981">EIP-2981</a>
 *
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 5:11 PM
 */
interface ERC2981 : Contract {

    @View
    @Type(Tuple::class)
    fun royaltyInfo(tokenId: String, value: Long): RoyaltyInfo

    data class RoyaltyInfo(
        val receiver: Address,
        val royaltyAmount: Uint
    )

    companion object {
        val INTERFACE_ID = "0x2a55205a"
    }

}