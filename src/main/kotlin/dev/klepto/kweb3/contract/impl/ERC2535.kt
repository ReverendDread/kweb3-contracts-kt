package dev.klepto.kweb3.contract.impl

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.abi.type.Bytes
import dev.klepto.kweb3.contract.Contract
import dev.klepto.kweb3.contract.Event
import dev.klepto.kweb3.contract.Transaction
import dev.klepto.kweb3.contract.Type
import dev.klepto.kweb3.contract.View

/**
 * @see <a href="https://eips.ethereum.org/EIPS/eip-2535">EIP-2535</a>
 *
 * @project kweb3-contracts-kt
 * @author andy@hlwgroup.dev - 5/10/2023 4:10 PM
 */
object ERC2535 {

    /**
     * Basic implementation of diamond init, this contract and function are used to initialize state variables and/or do other actions
     * when the [ERC2535.IDiamondCut.diamondCut] function is called.
     * It is expected that this contract is customized if you want to deploy your diamond with data from a deployment script.
     * Use the init function to initialize state variables of your diamond. Add parameters to the init function if you need to.
     * [DiamondInit] can be used during deployment or for upgrades.
     */
    interface DiamondInit : Contract {

        @Transaction
        fun init()

    }

    /**
     * A version of [DiamondInit] can be used to execute multiple initialization functions.
     * It is expected that this contract is customized if you want to deploy or upgrade your diamond with it.
     */
    interface DiamondMultiInit : Contract {

        @Transaction
        fun multiInit(addresses: List<Address>, calldata: List<Bytes>)

    }

    /**
     *
     */
    interface IDiamond : Contract {

        data class FacetCut(
            val facetAddress: Address,
            val action: Int,
            @field:Type(valueSize = 4) val functionSelectors: List<Bytes>
        )

        /**
         *
         */
        @Event
        data class DiamondCut(
            val cuts: List<FacetCut>,
            val init: Address,
            val calldata: Bytes
        )

        companion object {
            const val FACET_CUT_ACTION_ADD = 0
            const val FACET_CUT_ACTION_REPLACE = 1
            const val FACET_CUT_ACTION_REMOVE = 2
        }

    }

    /**
     *
     */
    interface IDiamondCut : IDiamond {

        /**
         * Add/replace/remove any number of functions and optionally execute a function with a delegatecall
         * @param cuts the facet addresses and function selectors
         * @param init the address of the function to execute [calldata]
         * @param calldata a function call, including function selector and arguments, [calldata] is executed with delegatecall on [init]
         */
        @Transaction
        fun diamondCut(cuts: List<IDiamond.FacetCut>, init: Address, calldata: Bytes)

    }

    /**
     * The diamond loupe contains all the view functions for a diamond
     */
    interface IDiamondLoupe : Contract {

        data class Facet(
            val facetAddress: Address,
            @field:Type(valueSize = 4) val functionSelectors: List<Bytes>
        )

        /**
         * Gets all facet addresses and their four byte function selectors
         * @return the facets
         */
        @View
        fun facets(): List<Facet>

        /**
         * Gets all the function selectors supported by a specific facet
         * @param facet the facet address
         * @return the function selectors
         */
        @View
        @Type(valueSize = 4)
        fun facetFunctionSelectors(facet: Address): List<Bytes>

        /**
         * Get all the facet addresses used by a diamond
         * @return the facet addresses
         */
        @View
        fun facetAddresses(): List<Address>

        /**
         * Get the facet that supports the given selector
         * @param functionSelector the function selector
         * @return the facet address, if the facet is not found, returns address(0)
         */
        @View
        fun facetAddress(functionSelector: Bytes): Address

    }

}