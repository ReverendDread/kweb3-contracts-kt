package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.abi.type.Uint
import dev.klepto.kweb3.contract.Contract
import dev.klepto.kweb3.contract.View

/**
 * ERC-5615 ERC-1155 Supply Extension
 * @see <a href="https://eips.ethereum.org/EIPS/eip-5615">ERC-5615</a>
 *
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 5:34 PM
 */
interface ERC5615 : Contract {

    /**
     * This function MUST return whether the given token id exists, previously existed, or may exist
     * @param id the token id of which to check the existence
     * @return whether the token exists, previously existed, or may exist
     */
    @View
    fun exists(id: Uint): Boolean

    /**
     * This function MUST return the number of tokens with a given id. If the token id does not exist, it MUST return 0.
     * @param id the token id of which fetch the total supply
     * @return the total supply of the given token id
     */
    @View
    fun totalSupply(id: Uint): Uint

}