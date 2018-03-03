/*

This is a rework of the Pkr pattern class from the BenoitLib library with an added feature: It has a min (set to 0.1 by default) and max argument (set to 1.0 by default) to protect your system from crashing if you for example modulate a dur parameter with a ugen that goes below 0. 

Add the file to your extensions folder and use it like this in a pattern: Pkrlive(~bus, minvalue, maxvalue)

*/

Pkrlive : Pfunc {
	*new {|bus, min=0.1, max=1.0|
		var check;
		var last = 0.0;
		
		bus = bus.asBus;

		// audio?
		bus.isSettable.not.if {
			"Not a kr Bus or NodeProxy. This will only yield 0".warn;
			^Pfunc({0});	
		};
		
		check = {bus.server.hasShmInterface}.try;
		
		check.if ({
			^Pfunc({bus.getSynchronous().wrap(min, max)});
		}, {
			"No shared memory interface detected. Use localhost server on SC 3.5 or higher to get better performance".warn;	
			bus.get({|v| last = v;});
			^Pfunc({bus.get({|v| last = v;}); last;});
		});
	}	
}