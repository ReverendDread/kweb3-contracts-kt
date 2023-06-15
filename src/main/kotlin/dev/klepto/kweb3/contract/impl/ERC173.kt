package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.Web3Response
import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.contract.Contract
import dev.klepto.kweb3.contract.Transaction

/**
 * ERC-173 Contract Ownership Standard
 * @see <a href="https://eips.ethereum.org/EIPS/eip-173">EIP-173</a>
 *
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 4:04 PM
 */
interface ERC173 : Contract {

    /**
     * Get the address of the owner
     * @return address of the owner
     */
    fun owner(): Address

    /**
     * Set the address of the new owner ofthe contract
     * @param newOwner address of the new owner of the contract, setting to zero address will renounce any ownership
     */
    @Transaction
    fun transferOwnership(newOwner: Address) : Web3Response

    companion object {
        val INTERFACE_ID = "0x7f5828d0"
    }

}