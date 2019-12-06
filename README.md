# Tower of Hanoi
#### A Recursive Solver! *(And Graphics Driver!)*

# What's The *Tower of Hanoi?*
It's a puzzle. You've got three columns, one of which is filled up with rings, stacked Smallest to Largest, Top to Bottom (respectively).
The rules, according to trusty [Wikipedia](https://en.wikipedia.org/wiki/Tower_of_Hanoi), are as follows:
>1. Only one disk can be moved at a time.
>2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.
>3. No larger disk may be placed on top of a smaller disk

![](hanoi.gif)
>*like this, see?*


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

# Alright, So How Does It *Solve?*
A wise fella once said
>I dunno

I am not that wise fella; nor am I a wise fella. But y'know what? Let me give you a quick breakdown:

You've got a Stack of Rings, yeah?

There's more than 1 Ring, yeah? ('cause if there was only 1, this'd be a piece of cake)
```
Ring.move(here, there);
```
But it's not, 'innit? Nay. But that *is* the Base Case, which is what we move at the end.

#### Hurry It Up, Will You?
Fine.
There are 3 Steps to Moving One Ring from one Column (the *Position* Column) to Another (a *Target* Column):
1. Move the Stack Above it to a Different Column
   - This is the *Swap*, or *Temporary* Column.
   - We need this so that the Stack in question (or: Ring in question / bottom-most Ring) can move to its *Target* Column
   - With the 'first' movement, we define the *Swap* Column as the Column that isn't the *Position* or *Target* Column
2. Move the Ring to the *Target* Column
   - Now, everything's set. But what about the rest of Stacks? They're all at the *Swap*! 
   - Well...
3. Move the Previous Stack on Top of the Ring (i.e. Place it onto the *Target* Column)
   - Now, let's think about this carefully. The Previous Stack needs its **own** *Swap* Column. What'll it be?
   - Well, the Previous Stack is in the Current Ring's/Stack's *Swap* Column. 
     - Thus: The Previous Stack's *Position* Column is defined as the Current Stack's *Swap* Column
   - And we know that the Previous Stack's *Target* Column is the Current Stack's *Target* Column
     - Thus: The Previous Stack's *Target* Column is defined as the Current Stack's *Target* Column
   - Process-of-Elimination leaves us with only one other option for the Previous Stack's *Swap* Column:
     - Thus: The Previous Stack's *Swap* Column is defined as the Current Stack's *Position* Column
    
Now, when the 'Stack Above' is equal to a Stack of 1, *that's* when we've reached our Base Case, and *that's* when we move our stack.

Ultimately, the key here is to know *how* to change the *Position*, *Swap*, and *Target* Columns. But once you've got the process of elimination down, *that's* when it clicks.

At least, that's when it clicked for me.

Enjoy!
