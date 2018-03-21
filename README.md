# PKjeldgaard

These are Pattern abstractions and hacks I have put together for my own personal use but maybe they'll come in handy for you!

Put this repo in your extensions folder (find it by evaluating
`Platform.userExtensionDir` or `Platform.systemExtensionDir` in SC) and then use them like so: 

### Proly
`Proly(steps: 50, curve: 'log', repeats: inf)`

This is something I hacked together for a performance. 

This is a pattern inspired by Roly Porter's 'MASS' in which there is a rolling
percussive instrument with a decaying duration. 

Works really nicely in the \dur key of a Pbind. For example like this:

```
Pbind(\dur, Proly(steps: 100, curve: 'log', repeats: inf)).play;
```

I used an early version of this at the end of this performance: https://www.youtube.com/watch?v=tLS4iNAYiuQ

### Pkrlive
`Pkrlive(bus: ~bus, min: 0.1, max: 1.0, frommin:-1.0, frommax:1.0)`

This is a rework of the Pkr pattern class from the BenoitLib library with one added feature: 

It has a min (set to 0.1 by default) and max argument (set to 1.0 by default) to protect your system from crashing if you for example modulate a dur parameter with a ugen that goes below 0. 

Internally it uses .linlin to map the values and by default it expects the output
of the bus to be between -1 and 1 but you can change this with the last two
parameters if you want. 

Example use (presumes a ProxySpace is active): 

```
(
~s = {SinOsc.kr(0.01)};

Pbind(\dur, Pkrlive(~s) * Pseq((1..10)/10, inf)).play;
)
```

### Preich 
`Preich(pattern, rate:0.1, repeats:inf)`

This one was inspired by Steve Reich's use of phasing patterns 

It's pretty simple: It takes an event pattern (a Pbind for example) and makes
a stretched copy playing out of phase by the amount given in rate

Example:

```
(
~p1 = Pbind(\dur, Pseq([0.25,1,0.5],inf), \degree, Pseq([1,2,5],inf));

Preich(~p1.source, rate:0.13, repeats:inf ).play;
)
```
