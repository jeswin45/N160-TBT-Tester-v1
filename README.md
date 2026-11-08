# N160 TBT Tester v0.2.0

Safety-locked Android diagnostic prototype for the Bajaj Pulsar N160 2V TBT interface.

## Safety scope

This project is intentionally limited to the publicly reverse-engineered/documented TBT service and TBT information characteristic.

It does **not**:
- discover or write to the CONTROL characteristic;
- contain firmware-update functionality;
- send engine, throttle, brake, ignition, or other vehicle-control commands;
- attempt firmware modification.

The app should be tested only while the motorcycle is stationary and safely parked.

## Important

The 48-byte frame in this prototype is a diagnostic placeholder. It is **not claimed to be the final N160 2V navigation packet format**. The exact packet structure must be verified against the user's cluster before building a real navigation feature.

## Build

The repository includes a GitHub Actions workflow at:

`.github/workflows/build-apk.yml`

After pushing this project to GitHub:
1. Open the repository's **Actions** tab.
2. Run **Build APK** (or push a commit).
3. Wait for the workflow to finish.
4. Download the `N160-TBT-Tester-debug-apk` artifact.

## Next stage

Once the TBT packet format is verified, the tester can be extended with:
- route calculation;
- turn instruction conversion;
- distance updates;
- Android navigation UI;
- automatic TBT updates.

Do not connect this prototype to a moving motorcycle for testing.
