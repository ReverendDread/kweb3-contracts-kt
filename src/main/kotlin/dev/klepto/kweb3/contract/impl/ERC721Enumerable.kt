package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.abi.type.Uint
import dev.klepto.kweb3.contract.Contract
import dev.klepto.kweb3.contract.View

/**
 * ERC-721 Non-Fungible Token Standard, optional enumeration extension
 * @see <a href="https://eips.ethereum.org/EIPS/eip-721">ERC-721 Non-Fungible Token Standard</a>
 *
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 2:59 PM
 */
interface ERC721Enumerable : Contract {

    /**
     * Gets the total number of tokens stored by the contract
     * @return the total number of tokens stored by the contract
     */
    @View
    fun totalSupply(): Uint

    /**
     * Gets the token ID at a given index
     * @param index the index of the token, must be less than [ERC721.totalSupply]
     * @return the number of tokens owned by `owner`
     */
    @View
    fun tokenByIndex(index: Uint): Uint

    /**
     * Gets the token ID at a given index of the tokens owned by a given address
     * @param owner the address to query the tokens of
     * @param index the index of the token, must be less than [ERC721.balanceOf]
     * @return the number of tokens owned by `owner`
     */
    @View
    fun tokenOfOwnerByIndex(owner: Address, index: Uint): Uint

    companion object {
        const val INTERFACE_ID = "0x780e9d63"
    }

}