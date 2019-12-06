# Tower of Hanoi
#### A Recursive Solver! *(And Graphics Driver!)*

# What's The *Tower of Hanoi?*
It's a puzzle. You've got three columns, one of which is filled up with rings, stacked Smallest to Largest, Top to Bottom (respectively).
The rules, according to trusty [Wikipedia](https://en.wikipedia.org/wiki/Tower_of_Hanoi), are as follows:
1. Only one disk can be moved at a time.
2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.
3. No larger disk may be placed on top of a smaller disk


# Why'd You Make This... Thing? You're *Reinventing The Wheel*
I wanted to challenge myself and figure out what all that jazz about *recursion* was really about. Up until this project, recursion was kinda funky. Now, it's slightly less funky

# But What Are These *Things?*
- *HanoiGame.java* is the Main Driver; it'll draw the graphics and whatnot.
- *Ring.java* makes up the Ring Object; this fella not only shows what to draw, but *also* carries the methods needed to move itself (as an individual)
- *Solver.java* is... well, it's the *solver.* This is the guy that implements the recursive solution, and is called within *HanoiGame.java*

# How Do I Try This Out?
Fire up a current(-ish) version of your Eclipse IDE, and stick these *.java* files into a new Java Project.
</br>*Name it something cool. For me, your friend.*
</br>Then, hit 'Run' (or fn+F11); Pull up the Console, and hit 
>Enter

That'll step through each step. Press and hold
>Enter

For a mind-melding journey through recursion
>Enjoy!

</br>You may be wondering why I didn't export this as an executable. I, too, wonder.
</br>Y'see: I, midst the throes of a late-night figuring-out-how-to-make-rectangles-appear-on-the-screen-session that simply *couldn't* wait, decided that implementing a MouseHandler to click through the solver's steps would make the project take far too long just to try out the *main attraction*—namely, the *recursive solver*

# Fine, But How Does It *Solve?*
A wise fella once said
>I dunno

I am not that wise fella; nor am I a wise fella. But y'know what? Let me give you a quick breakdown:

You've got a Stack of Rings, yeah?

There's more than 1 Ring, yeah? ('cause if there was
