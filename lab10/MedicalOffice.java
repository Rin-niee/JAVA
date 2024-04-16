/*С помощью многопоточного приложения смоделируйте следующую задачу.
Пусть имеется процедурный кабинет с несколькими медсёстрами. С каждой
из них связан свой поток команд. Пусть имеется очередь из пациентов. Для
каждого из пациентов при создании задаётся своё (случайное) время
обслуживания. Потоки, связанные с медсёстрами «извлекают» пациентов из
очереди и обслуживают нужное время. При извлечении данных из очереди
она должна блокироваться.
Программа должна выводить ФИО или номер пациента, у какой медсестры и
сколько времени он обслуживался. Программа заканчивается, когда все
пациенты обслужены. */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MedicalOffice
{
   static class Patient
   {
        String name;
        int serviceTime;

        public Patient(String name, int serviceTime)
        {
            this.name = name;
            this.serviceTime = serviceTime;
        }
    }

    static class Nurse extends Thread
    {
        String name;
        Queue<Patient> patientsQueue;

        public Nurse(String name, Queue<Patient> patientsQueue)
        {
            this.name = name;
            this.patientsQueue = patientsQueue;
        }

        public void run()
        {
            while (true)
            {
                Patient patient;
                synchronized (patientsQueue)
                {
                    patient = patientsQueue.poll(); //удаление из очереди
                }
            if (patient == null) break;
                try {
                    System.out.println(name + " served patient " + patient.name + " for " + patient.serviceTime + " time.");
                    Thread.sleep(patient.serviceTime * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Queue<Patient> patientsQueue = new LinkedList<>();
        for (int i = 1; i <= 10; i++)
        {
            patientsQueue.add(new Patient("Patient" + i, new Random().nextInt(10) + 1));
        }

        Nurse[] nurses = new Nurse[3];
        for (int i = 0; i < nurses.length; i++)
        {
            nurses[i] = new Nurse("Nurse" + (i + 1), patientsQueue);
            nurses[i].start();
        }

        for (Nurse nurse : nurses)
        {
            try {
                nurse.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All patients have been served.");
    }
}
