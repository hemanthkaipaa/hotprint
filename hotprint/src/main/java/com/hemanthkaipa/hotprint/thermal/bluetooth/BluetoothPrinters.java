package com.hemanthkaipa.hotprint.thermal.bluetooth;


import com.hemanthkaipa.hotprint.bluetooth.BluetoothDeviceSocketConnexion;
import com.hemanthkaipa.hotprint.bluetooth.BluetoothDevices;


public class BluetoothPrinters extends BluetoothDevices {
    
    /**
     * Easy way to get the first bluetooth printer paired / connected.
     *
     * @return a BluetoothPrinterSocketConnexion instance
     */
    public static BluetoothPrinterSocketConnexion selectFirstPairedBluetoothPrinter() {
        BluetoothPrinters printers = new BluetoothPrinters();
        BluetoothPrinterSocketConnexion[] bluetoothPrinters = printers.getList();
        
        if (bluetoothPrinters != null && bluetoothPrinters.length > 0) {
            for (BluetoothPrinterSocketConnexion printer : bluetoothPrinters) {
                if (printer.connect()) {
                    return printer;
                }
            }
        }
        return null;
    }
    
    
    /**
     * Get a list of bluetooth printers.
     *
     * @return an array of BluetoothPrinterSocketConnexion
     */
    public BluetoothPrinterSocketConnexion[] getList() {
        BluetoothDeviceSocketConnexion[] bluetoothDevicesList = super.getList();
    
        if(bluetoothDevicesList == null) {
            return null;
        }
    
        int i = 0, j = 0;
        BluetoothPrinterSocketConnexion[] bluetoothPrintersTmp = new BluetoothPrinterSocketConnexion[bluetoothDevicesList.length];
        for (BluetoothDeviceSocketConnexion device : bluetoothDevicesList) {
            bluetoothPrintersTmp[i++] = new BluetoothPrinterSocketConnexion(device.getDevice());
        }
        BluetoothPrinterSocketConnexion[] bluetoothPrinters = new BluetoothPrinterSocketConnexion[i];
        for (BluetoothPrinterSocketConnexion device : bluetoothPrintersTmp) {
            if (device != null) {
                bluetoothPrinters[j++] = device;
            }
        }
        return bluetoothPrinters;
    }
    
}
