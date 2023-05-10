package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.abi.type.Bytes
import dev.klepto.kweb3.abi.type.Uint
import dev.klepto.kweb3.contract.Contract
import dev.klepto.kweb3.contract.Cost
import dev.klepto.kweb3.contract.Event
import dev.klepto.kweb3.contract.Transaction
import dev.klepto.kweb3.contract.View

/**
 * ERC-721 Non-Fungible Token Standard
 * @see <a href="https://eips.ethereum.org/EIPS/eip-721">ERC-721 Non-Fungible Token Standard</a>
 *
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 2:58 PM
 */
interface ERC721 : Contract {

    /**
     * This emits when ownership of any NFT changes by any mechanism
     */
    @Event("Transfer")
    data class TransferEvent(
        @field:Event.Indexed val from: Address,
        @field:Event.Indexed val to: Address,
        @field:Event.Indexed val tokenId: Uint
    )

    /**
     * This emits when the approved address for an NFT is changed or reaffirmed.
     * The zero address indicates there is no approved address.
     */
    @Event("Approval")
    data class ApprovalEvent(
        @field:Event.Indexed val owner: Address,
        @field:Event.Indexed val approved: Address,
        @field:Event.Indexed val tokenId: Uint
    )

    /**
     * This emits when an operator is enabled or disabled for an owner.
     * The operator can manage all NFTs of the owner.
     */
    @Event("ApprovalForAll")
    data class ApprovalForAllEvent(
        @field:Event.Indexed val owner: Address,
        @field:Event.Indexed val operator: Address,
        @field:Event.Indexed val approved: Boolean
    )

    /**
     * Count all NFTs assigned to an owner
     * @param owner an address for whom to query the balance
     * @return The number of NFTs owned by [owner], possibly zero
     */
    @View
    fun balanceOf(owner: Address): Uint

    /**
     * Find the owner of an NFT
     * @param tokenId the identifier for an NFT
     * @return the address of the owner of the NFT
     */
    @View
    fun ownerOf(tokenId: Uint): Address

    /**
     * Transfers the ownership of an NFT from one address to another address
     * @param from current owner of the NFT
     * @param to new owner
     * @param tokenId the NFT to transfer
     * @param data additional data with no specified format, sent in call to `to`
     */
    @Transaction
    fun safeTransferFrom(from: Address, to: Address, tokenId: Uint, data: Bytes)

    /**
     * Transfer ownership of an NFT
     * @param from current owner of the NFT
     * @param to new owner
     * @param tokenId the NFT to transfer
     */
    @Transaction
    fun transferFrom(from: Address, to: Address, tokenId: Uint)

    /**
     * Change or reaffirm the approved address for an NFT
     * @param approved the new approved NFT controller
     * @param tokenId the NFT to approve
     */
    @Transaction
    fun approve(approved: Address, tokenId: Uint)

    /**
     * Enable or disable approval for a third party ("operator") to manage all of caller's assets
     * @param operator address to add to the set of authorized operators
     * @param approved true if the operator is approved, false to revoke approval
     */
    @Transaction
    fun setApprovalForAll(operator: Address, approved: Boolean)

    /**
     * Get the approved address for a single NFT
     * @param tokenId the NFT to find the approved address for
     * @return the address approved for this nft, or the zero address if there is none
     */
    @View
    fun getApproved(tokenId: Uint): Address

    /**
     * Query if an address is an authorized operator for another address
     * @param owner the address that owns the NFTs
     * @param operator the address that acts on behalf of the owner
     * @return true if operator is an approved operator for owner, false otherwise
     */
    @View
    fun isApprovedForAll(owner: Address, operator: Address): Boolean

    companion object {
        const val INTERFACE_ID = "0x80ac58cd"
    }

}