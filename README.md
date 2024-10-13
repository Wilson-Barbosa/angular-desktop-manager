# Angular Desktop Manager
Application that allows developers to manage their Angular Applications. Built with JavaFX 21.

## What the app does?
The application tracks your LOCAL Angular projects, saves the information on a .json file and displays the information on the GUI, allowing you to check for info and perform Angular CLI commands.

## How does it work?
- 

## What OS does it support?
Currently I'm working only on Windows, but I plan to add support for Linux in the near future. 

Working with macOS is a far gone possibility right now, since I never worked with it, therefore I assume (that is a pretty big and uninformed assumption though) it would take some time to implement it.

## What do I plan to add in the future
I'm open to suggestions :) but right now I'm these in mind:

- Linux support
- Integration with gitHub's API, so I can search for remote projects as well
- Option to let a user add a project manually too
- Add themes, like dark mode and other stuff

## Why did I built this?
Long story short: I basically created it for my personal use and to learn a bit more about Software development and what best tool to use than Java, am I right? 

When studying Java and OOP I had a lot of theorical knowledge and needed to put it in practice to really solidify and internalize core concepts.

I have lots of Angular projects installed locally on my machine and they were built on different versions. Very often I would go back to them to check for few details or implementations and as you may or may not know, web development grows fast, with NodeJS projects such as Angular having a particularly high number of dependencies. Given this situation it would be quite common for me to manually check each .json files, just to forget a few minutes later. 

Inspired on the git's GUI I decided to built my own GUI application that would allow me to quickly check for Angular Projects and inspect the libraries people would install, such as Bootstrap, Angular Materials, NgIcons etc...

## Technologies
- JavaFX version 21
- Jpackage to package the application
- JSON-Java library, also known as org.json, to perfom operations on, well, json files
- Visual Studio Code as my IDE