# Codespaces

We have tried to make this tutorial as easy as possible to use, so you have the option to use GitHub Codespaces, which will give you a completely configured environment running in the Cloud without the need to even check out the code to your local machine. You can even run it on  browser on a tablet, although you will want to use a device that has a real keyboard unless you hate yourself.

## Creating a Codespace

First, you will want to Fork the main repo so that you're able to work in your own space. Click 'fork' at the top of this repo.

![Fork](/assets/fork.png)

You will see the following screen, make sure to uncheck 'Copy the main branch only' as this tutorial uses branches to walk you through each exercise and provide you with a working copy of the code at each step in case you get stuck.

![Create a new fork](/assets/create-a-new-fork.png)

Now, in your fork click on the down arrow next to the green 'Code' button, select the Codespaces tab if it isn't selected and click the '+' button.

![Create Codespace](/assets/create-codespace.png)

Depending on your pre-existing configuration, GitHub may try to automatically open the Codespace in a browser tab or launch Visual Studio Code locally on your machine if you have it installed, from where it will setup a remote connection to the Codespace you have just created.

If this doesn't happen automatically, click again on the little down arrow in the 'Code' button and you should see your codespace. Click on the three dots next to the Codespace name and you will see the menu below.

![Manage your codespace](/assets/manage-codespace.png)

Select 'Open in ...' and you will see the following submenu.

![Open In](/assets/open-codespace-in.png)

If you want the simplest possible experience choose 'Open in browser' if you know you already have one of the other IDEs installed and setup locally feel free to use that, but we won't cover how to install a local IDE here.

## Using your Codespace

Assuming you've chosen the browser option, you will see something similar to below.

![Setting up your Codespace](/assets/setting-up-your-codepace.png)

After a few seconds to a minute, you should see an in browser version of Visual Studio Code running with the repo checkout.

![Running Codespace](/assets/running-codespace.png)

You Codespace is preconfigured with the Java JDK, Maven and other tools you will need for the Tutorial. You may however need to tell VS Code to import the Java Proejct explicitly, else it is possible that the Test Runner won't work.

![Import Java Project](/assets/import-java-project.png)

Once the import process has run you should see the project name replace the Import Projects button you clicked previously.

![Imported project](/assets/imported-project.png)

You are now setup and ready to go with the tutorial. Change your branch back to 'main' and get going!