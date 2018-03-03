// Use the finite state machine pattern to modify an existing pattern
//
// The pattern patternToBeMorphed will have its values overwritten by
// the values in the Pfsm
Pfsmmorph {
    *new{|patternToBeMorphed, listOfItemsAndStates|
        ^Pchain(patternToBeMorphed, Pfsm(listOfItemsAndStates));
    }
}
