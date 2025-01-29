package dev.lpa.sealed;

public sealed abstract class SpecialAbstractClass permits FinalKid,
        NonSealedKid, SealedKid, SpecialAbstractClass.Kid {

    final class Kid extends SpecialAbstractClass {

    }

}
