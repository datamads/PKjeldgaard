// This one was inspired by Steve Reich's use of phasing patterns 
//
// It's pretty simple: It takes an event pattern (a Pbind for example) and makes
// a copy playing out of phase by the amount given in rate


Preich : Pattern {
    *new{|pattern, rate=0.1, repeats=inf|
        ^Ppar([
            pattern,
            Pbindf(pattern.source, \stretch, Pkey(\stretch) * (1-rate))
        ], repeats)
    }
}
