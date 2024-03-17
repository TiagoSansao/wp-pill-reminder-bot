package org.pillreminder;

import it.auties.whatsapp.api.QrHandler;
import it.auties.whatsapp.api.Whatsapp;

public class PillReminder {
    public static void main(String[] args) {
        PillReminder pillReminder = new PillReminder();
        pillReminder.instanceBot();

        System.out.println("vapo");

    }

    private synchronized void instanceBot() {
        Whatsapp instance = Whatsapp
                .webBuilder()
                .firstConnection()
                .name("pill-reminder")
                .autodetectListeners(true)
                .unregistered(QrHandler.toTerminal())
                .connect().join()
                .addLoggedInListener(api -> System.out.printf("Connected: %s%n", api.store().privacySettings()))
                .addDisconnectedListener(reason -> System.out.printf("Disconnected: %s%n", reason));

        System.out.println(instance);
    }
}

