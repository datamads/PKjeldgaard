/*
Proly
by Mads Kjeldgaard

This is something I hacked together for a performance. 

This is a pattern inspired by Roly Porter's 'MASS' in which there is a rolling
percussive instrument with a decaying duration. 

Works really nicely in the \dur key of a Pbind

*/

Proly : Pattern {
    *new{|steps=50, curve = 'log', repeats=inf|

    var linpat = Ppatlace([
            Pn(p {: x / x.pow(2), x <- (1..(steps/2).asInt)}, inf),
            Pn(p {: Rest(x / x.pow(2)), x <- (1..(steps/2).asInt)}, inf)
            ],repeats);

    var logpat = Ppatlace([
            Pseq([1, p {: x.log(2)/x, x <- (2..(steps/2).asInt)}], inf),
            Pseq([Rest(1), p {: Rest(x.log(2)/x), x <- (2..(steps/2).asInt)}], inf)
            ],repeats);

    case
        {curve == 'lin'} {^linpat}
        {curve == 'log'} {^logpat};

        }
    }
