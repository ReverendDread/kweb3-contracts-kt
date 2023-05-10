package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.abi.type.Uint
import dev.klepto.kweb3.contract.Contract
import dev.klepto.kweb3.contract.Event
import dev.klepto.kweb3.contract.Transaction
import dev.klepto.kweb3.contract.View

/**
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 5:39 PM
 */
interface ERC5216 : Contract {

    /**
     * Emitted when [account] grants or revokes permission to [operator] to transfer their tokens, according to [id] and with an amount: [amount].
     */
    @Event("ApprovalByAmount")
    data class ApprovalByAmountEvent(
        @field:Event.Indexed val account: Address,
        @field:Event.Indexed val operator: Address,
        val id: Uint,
        val amount: Uint
    )

    /**
     * Grants permission to [operator] to transfer the caller's tokens, according to [id] and with an amount: [amount].
     * Emits an [ApprovalByAmountEvent].
     * @param operator The address to grant permission to.
     * @param id The ID of the token to grant permission for.
     * @param amount The amount of tokens to grant permission for.
     */
    @Transaction
    fun approve(operator: Address, id: Uint, amount: Uint)

    /**
     * Gets the amount allocated to [operator] approved to transfer [account]'s tokens, according to [id].
     * @param account The address to check the amount of tokens approved for.
     * @param operator The address to check the amount of tokens approved for.
     * @param id The ID of the token to check the amount of tokens approved for.
     */
    @View
    fun allowance(account: Address, operator: Address, id: Uint): Uint

}