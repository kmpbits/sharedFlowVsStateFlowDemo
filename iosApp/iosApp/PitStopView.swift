//
//  PitStopView.swift
//  iosApp
//
//  Created by Joel Caetano on 22/03/2026.
//

import SwiftUI

struct PitStopView: View {
    @StateObject private var holder = PitStopViewModelHolder()
    
    var body: some View {
        VStack(spacing: 16) {
            Text("Lap: \(holder.lapCount)")
                .font(.largeTitle)
            
            if let alert = holder.alertMessage {
                Text(alert)
                    .foregroundColor(.red)
            }
            
            Button("Next Lap") { holder.nextLap() }
                .buttonStyle(.borderedProminent)
            
            Button("Trigger Pit Stop") { holder.triggerPitStop(reason: "Change tires") }
                .buttonStyle(.bordered)
            
            Button("Reset") { holder.reset() }
                .buttonStyle(.bordered)
        }
        .padding()
    }
}

#Preview {
    PitStopView()
}
