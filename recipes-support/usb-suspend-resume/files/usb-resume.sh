#!/bin/sh
echo ci_hdrc.1 > /sys/bus/platform/drivers/ci_hdrc/unbind
echo ci_hdrc.1 > /sys/bus/platform/drivers/ci_hdrc/bind
echo ci_hdrc.0 > /sys/bus/platform/drivers/ci_hdrc/unbind
echo ci_hdrc.0 > /sys/bus/platform/drivers/ci_hdrc/bind
/bin/sh -c '/bin/cat /proc/device-tree/model > \
                                   /sys/kernel/config/usb_gadget/g1/strings/0x409/product'
/bin/sh -c '/bin/cat /proc/device-tree/serial-number > \
                                   /sys/kernel/config/usb_gadget/g1/strings/0x409/serialnumber'
/bin/sh -c '/bin/echo `ls /sys/class/udc/` > \
                                    /sys/kernel/config/usb_gadget/g1/UDC'
