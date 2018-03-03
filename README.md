# PKjeldgaard
Custom pattern classes for SuperCollider

These are Pattern classes and hacks I have made for my own personal use but maybe they'll come in handy for you!

Put this repo in your extensions folder and use them like so: 

### Proly
`Proly(steps: 50, curve: 'log', repeats: inf)`

This is something I hacked together for a performance. 

This is a pattern inspired by Roly Porter's 'MASS' in which there is a rolling
percussive instrument with a decaying duration. 

Works really nicely in the \dur key of a Pbind

### Pkrlive
`Pkrlive(bus: ~bus, min: 0.1, max: 1.0)`

This is a rework of the Pkr pattern class from the BenoitLib library with one added feature: 

It has a min (set to 0.1 by default) and max argument (set to 1.0 by default) to protect your system from crashing if you for example modulate a dur parameter with a ugen that goes below 0. 

### Pfsmmorph
`Pfsmmorph(patternToBeMorphed, listOfItemsAndStates)`

Use a finite state machine pattern to modify an existing pattern
